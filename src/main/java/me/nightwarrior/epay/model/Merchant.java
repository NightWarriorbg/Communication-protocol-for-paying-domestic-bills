package me.nightwarrior.epay.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@XmlRootElement(name = "merchant")
@XmlAccessorType(XmlAccessType.FIELD)
public class Merchant {

    @XmlElement(name = "merchant_id", required = true)
    private String merchantId;

    @XmlElement(name = "full_name")
    private String fullName;

    @XmlElement(name = "full_name_en")
    private String fullNameEn;

    @XmlElement(name = "web_name")
    private String webName;

    @XmlElement(name = "subscr_number_type")
    private String subscrNumberType;

    @XmlElement
    private Boolean active;

    @XmlElement
    private Integer category;

    @XmlElement(name = "category_name")
    private String categoryName;

    @XmlElement(name = "merchant_type")
    private Integer merchantType;

    @XmlElement(name = "merchant_partial")
    private Boolean merchantPartial;

    @XmlElement(name = "merchant_invoice")
    private Boolean merchantInvoice;

    @XmlElement(name = "merchant_short_desc")
    private String merchantShortDesc;

    @XmlElement(name = "merchant_long_desc")
    private String merchantLongDesc;

    @XmlElement(name = "subscr_number_re")
    private String subscrNumberRe;

    @XmlElement(name = "subscr_number_re_help")
    private String subscrNumberReHelp;

}