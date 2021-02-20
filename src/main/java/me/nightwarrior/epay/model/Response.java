package me.nightwarrior.epay.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import me.nightwarrior.epay.DateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@RequiredArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "epay_ws_response")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    @XmlElement
    private final String status;

    @XmlElement(name = "valid_to")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private final Date validTo;

    @XmlElement
    private final Double amount;

    @XmlElement
    private final Double fee;

    @XmlElement
    private final Double total;

    @XmlElement(name = "short_desc")
    private final String shortDesc;

    @XmlElement(name = "long_desc")
    private final String longDesc;

    @XmlElement(name = "second_id")
    private final String secondId;

    @Setter
    @XmlElement(name = "error_code")
    private String errorCode;

    @Setter
    @XmlElement(name = "error_desc")
    private String errorDesc;

}
