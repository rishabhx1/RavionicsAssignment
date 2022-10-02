
package models;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "course_details",
    "accommodation_details"
})
@Generated("jsonschema2pojo")
public class CollegeDetails {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("course_details")
    private CourseDetails courseDetails;
    @JsonProperty("accommodation_details")
    private AccommodationDetails accommodationDetails;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CollegeDetails() {
    }

    /**
     * 
     * @param courseDetails
     * @param accommodationDetails
     * @param name
     * @param id
     */
    public CollegeDetails(String id, String name, CourseDetails courseDetails, AccommodationDetails accommodationDetails) {
        super();
        this.id = id;
        this.name = name;
        this.courseDetails = courseDetails;
        this.accommodationDetails = accommodationDetails;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("course_details")
    public CourseDetails getCourseDetails() {
        return courseDetails;
    }

    @JsonProperty("course_details")
    public void setCourseDetails(CourseDetails courseDetails) {
        this.courseDetails = courseDetails;
    }

    @JsonProperty("accommodation_details")
    public AccommodationDetails getAccommodationDetails() {
        return accommodationDetails;
    }

    @JsonProperty("accommodation_details")
    public void setAccommodationDetails(AccommodationDetails accommodationDetails) {
        this.accommodationDetails = accommodationDetails;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CollegeDetails.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("courseDetails");
        sb.append('=');
        sb.append(((this.courseDetails == null)?"<null>":this.courseDetails));
        sb.append(',');
        sb.append("accommodationDetails");
        sb.append('=');
        sb.append(((this.accommodationDetails == null)?"<null>":this.accommodationDetails));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.courseDetails == null)? 0 :this.courseDetails.hashCode()));
        result = ((result* 31)+((this.accommodationDetails == null)? 0 :this.accommodationDetails.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CollegeDetails) == false) {
            return false;
        }
        CollegeDetails rhs = ((CollegeDetails) other);
        return ((((((((this.courseDetails == rhs.courseDetails)||((this.courseDetails!= null)&&this.courseDetails.equals(rhs.courseDetails))))&&((this.accommodationDetails == rhs.accommodationDetails)||((this.accommodationDetails!= null)&&this.accommodationDetails.equals(rhs.accommodationDetails))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties)))));
    }

}
