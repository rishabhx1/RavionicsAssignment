
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
    "is_ac",
    "fees"
})
@Generated("jsonschema2pojo")
public class AccommodationDetails {

    @JsonProperty("is_ac")
    private Boolean isAc;
    @JsonProperty("fees")
    private Double fees;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AccommodationDetails() {
    }

    /**
     * 
     * @param fees
     * @param id
     * @param isAc
     */
    public AccommodationDetails(Boolean isAc, Double fees) {
        super();
        this.isAc = isAc;
        this.fees = fees;
    }

    @JsonProperty("is_ac")
    public Boolean getIsAc() {
        return isAc;
    }

    @JsonProperty("is_ac")
    public void setIsAc(Boolean isAc) {
        this.isAc = isAc;
    }

    @JsonProperty("fees")
    public Double getFees() {
        return fees;
    }

    @JsonProperty("fees")
    public void setFees(Double fees) {
        this.fees = fees;
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
        sb.append(AccommodationDetails.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("isAc");
        sb.append('=');
        sb.append(((this.isAc == null)?"<null>":this.isAc));
        sb.append(',');
        sb.append("fees");
        sb.append('=');
        sb.append(((this.fees == null)?"<null>":this.fees));
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
        result = ((result* 31)+((this.fees == null)? 0 :this.fees.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.isAc == null)? 0 :this.isAc.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AccommodationDetails) == false) {
            return false;
        }
        AccommodationDetails rhs = ((AccommodationDetails) other);
        return (((((this.fees == rhs.fees)||((this.fees!= null)&&this.fees.equals(rhs.fees))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.isAc == rhs.isAc)||((this.isAc!= null)&&this.isAc.equals(rhs.isAc))));
    }

}
