package APItests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "title",
        "description",
        "content",
        "authorId",
        "mainImage",
        "updatedAt",
        "createdAt",
        "labels",
        "delayPublishTo",
        "draft"
})
@Data
public class Datum {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("title")
    public String title;
    @JsonProperty("description")
    public String description;
    @JsonProperty("content")
    public String content;
    @JsonProperty("authorId")
    public Integer authorId;
    @JsonProperty("mainImage")
    public MainImage mainImage;
    @JsonProperty("updatedAt")
    public String updatedAt;
    @JsonProperty("createdAt")
    public String createdAt;
    @JsonProperty("labels")
    public List<Object> labels = null;
    @JsonProperty("delayPublishTo")
    public String delayPublishTo;
    @JsonProperty("draft")
    public Boolean draft;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
