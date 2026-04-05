import java.io.*;
import java.net.*;
import java.util.*;

public class MyResponseCache extends ResponseCache {

    private final Map<URI, MyCacheResponse> cache = new HashMap<>();

    @Override
    public CacheResponse get(URI uri, String requestMethod, Map<String, List<String>> requestHeaders) {
        MyCacheResponse cachedResponse = cache.get(uri);
        if (cachedResponse != null) {
            cachedResponse.setFromCache(true);
        }
        return cachedResponse;
    }

    @Override
    public CacheRequest put(URI uri, URLConnection conn) throws IOException {
        return new MyCacheRequest(uri, conn);
    }

    private class MyCacheRequest extends CacheRequest {
        private final ByteArrayOutputStream body = new ByteArrayOutputStream();
        private final URI uri;
        private final URLConnection conn;

        MyCacheRequest(URI uri, URLConnection conn) {
            this.uri = uri;
            this.conn = conn;
        }

        @Override
        public OutputStream getBody() {
            return body;
        }

        @Override
        public void abort() {
            body.reset();
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            if (body.size() > 0) {
                cache.put(uri, new MyCacheResponse(conn.getHeaderFields(), body.toByteArray(), false));
            }
        }
    }

    private class MyCacheResponse extends CacheResponse {
        private final Map<String, List<String>> headers;
        private final byte[] body;
        private boolean fromCache;

        MyCacheResponse(Map<String, List<String>> headers, byte[] body, boolean fromCache) {
            this.headers = headers;
            this.body = body;
            this.fromCache = fromCache;
        }

        public void setFromCache(boolean fromCache) {
            this.fromCache = fromCache;
        }

        public boolean isFromCache() {
            return fromCache;
        }

        @Override
        public Map<String, List<String>> getHeaders() {
            return headers;
        }

        @Override
        public InputStream getBody() {
            return new ByteArrayInputStream(body);
        }
    }

    public static void main(String[] args) throws Exception {
        MyResponseCache cache = new MyResponseCache();
        ResponseCache.setDefault(cache);
        
        URL url = new URL("http://example.com");
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();

        // Check if the response was from cache
        URI uri = url.toURI();
        MyCacheResponse cachedResponse = (MyCacheResponse) cache.get(uri, "GET", new HashMap<>());
        if (cachedResponse != null && cachedResponse.isFromCache()) {
            System.out.println("The response was from the cache.");
        } else {
            System.out.println("The response was fetched from the network.");
        }
    }
}
