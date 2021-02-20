package me.nightwarrior.epay.service;

import me.nightwarrior.epay.model.Merchant;
import me.nightwarrior.epay.model.MerchantList;
import me.nightwarrior.epay.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MerchantService {

    @Autowired
    MerchantRepository merchantRepository;

    public MerchantList getMerchantsDataList() {
        merchantRepository.fillWithData();
        List<Merchant> merchants = new ArrayList<>();
        merchants.addAll(merchantRepository.getMerchants());

        int size = merchantRepository.getSize();
        return new MerchantList(size, merchants);
    }

}
