package me.nightwarrior.epay.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import me.nightwarrior.epay.DateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@Data
@NoArgsConstructor(access=AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "epay_ws_request")
@XmlAccessorType(XmlAccessType.FIELD)
public class Request {

    @XmlElement(name = "merchant_id")
    private final String merchantId;

    @XmlElement(name = "subscr_number")
    private final String subscrNumber;

    @XmlElement(name = "transaction_id")
    private final String transactionId;

    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    private final Date dt;

    @XmlElement
    private final Double amount;

}
