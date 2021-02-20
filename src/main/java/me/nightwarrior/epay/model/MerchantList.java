package me.nightwarrior.epay.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@NoArgsConstructor(access= AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "epay_ws_response>")
public class MerchantList {

    @XmlElement(name = "merchants")
    private final Integer count;

    @XmlElement(name = "merchant")
    private final List<Merchant> merchantsList;


}
