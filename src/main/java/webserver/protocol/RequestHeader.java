package webserver.protocol;

import java.util.Map;
import java.util.Objects;

public class RequestHeader {

    private final HttpMethod httpMethod;
    private final String path;
    private final String httpVersion;
    private final Map<String, String> queryParams;
    private final Map<String, String> headers;

    RequestHeader(final HttpMethod httpMethod, final String path, final String httpVersion,
        final Map<String, String> queryParams, final Map<String, String> headers) {
        validate(httpMethod, path, httpVersion, queryParams, headers);
        this.httpMethod = httpMethod;
        this.path = path;
        this.httpVersion = httpVersion;
        this.queryParams = queryParams;
        this.headers = headers;
    }

    private void validate(final HttpMethod httpMethod, final String path, final String httpVersion,
        final Map<String, String> queryParams, final Map<String, String> headers) {
        if (Objects.isNull(httpMethod)) {
            throw new IllegalArgumentException("httpMethod가 유효하지 않습니다: " + httpMethod);
        }
        if (Objects.isNull(path) || path.isEmpty()) {
            throw new IllegalArgumentException("path가 유효하지 않습니다: " + path);
        }
        if (Objects.isNull(httpVersion) || httpVersion.isEmpty()) {
            throw new IllegalArgumentException("httpVersion가 유효하지 않습니다: " + httpVersion);
        }
        if (Objects.isNull(queryParams)) {
            throw new IllegalArgumentException("queryParams가 유효하지 않습니다: " + null);
        }
        if (Objects.isNull(headers)) {
            throw new IllegalArgumentException("headers가 유효하지 않습니다: " + null);
        }
    }

    public boolean hasQueryParams() {
        return !queryParams.isEmpty();
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public String getPath() {
        return path;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}
