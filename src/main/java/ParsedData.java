import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class ParsedData {
    private final String group;
    private final PartData<Map<String, Object>> header;
    private final PartData<Map<String, Object>> card;
    private final PartData<Map<String, Object>> resolution;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PartData<DATA> {
        private String html;
        private List<String> headers;
        private List<String> links;
        private DATA data;
    }
}

