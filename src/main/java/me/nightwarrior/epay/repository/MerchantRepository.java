package me.nightwarrior.epay.repository;

import lombok.Data;
import me.nightwarrior.epay.model.Merchant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Data
@Repository
public class MerchantRepository implements ObjectRepository<Merchant> {

    private List<Merchant> merchants = new ArrayList<>();;

    @Override
    public void store(Merchant element) {
        getMerchants().add(element);
    }

    @Override
    public Merchant get(int id) {
        return getMerchants().get(id);
    }

    @Override
    public Merchant search(String name) {
        return null;
    }

    @Override
    public Merchant delete(int id) {
        Merchant merchant = getMerchants().get(id);
        getMerchants().remove(id);
        return merchant;
    }

    public int getSize() {
        return getMerchants().size();
    }

    public void fillWithData() {
        Merchant merchant = new Merchant(
                "0000001","Бисквити Орео", "Oreo Cookies", "oreo", "Абонаментен номер", true, 1, "Категория", 1, true,
                true, "Бисквити орео", "Неустоими бисквити орео", "0000007", "Помощ"
        );
        this.store(merchant);
    }
}
