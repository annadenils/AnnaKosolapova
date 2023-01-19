package jdi.objects;

import com.epam.jdi.tools.DataClass;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
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

    public List<String> getLog() {
        int sumOfNumbers = summary.get(0) + summary.get(1);
        List<String> result = new ArrayList<>();
        String elements = String.join(", ", element);
        String vegetables = String.join(", ", getVegetable());
        result.add("Color: " + color);
        result.add("Metal: " + metal);
        result.add("Summary: " + sumOfNumbers);
        result.add("Elements: " + elements);
        result.add("Vegetables: " + vegetables);
        return result;
    }


}
