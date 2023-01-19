package jdi.objects;

import com.epam.jdi.tools.DataClass;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class MetalsColors extends DataClass<MetalsColors> {
    @JsonProperty("summary")
    public List<Integer> summary;

    @JsonProperty("elements")
    public List<String> element;

    @JsonProperty("color")
    public String color;

    @JsonProperty("metals")
    public String metal;

    @JsonProperty("vegetables")
    public List<String> vegetable;

    public MetalsColors(List<Integer> summary, List<String> element,
                        String color, String metal, List<String> vegetable) {
        this.summary = summary;
        this.element = element;
        this.color = color;
        this.metal = metal;
        this.vegetable = vegetable;
    }

    public List<Integer> getSummary() {
        return summary;
    }

    public List<String> getElement() {
        return element;
    }

    public String getColor() {
        return color;
    }

    public String getMetal() {
        return metal;
    }

    public List<String> getVegetable() {
        return vegetable;
    }


}
