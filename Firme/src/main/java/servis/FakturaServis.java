package servis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.FakturaRepozitorijum;
import model.Faktura;

@Service
public class FakturaServis {

	@Autowired
	private FakturaRepozitorijum fakturaRepozitorijum;
	
	public void novaFaktura(Faktura faktura){
		fakturaRepozitorijum.save(faktura);
	}
	
	public List<Faktura> nadjiSveFakture(){
		List<Faktura> fakture = new ArrayList<Faktura>();
		fakturaRepozitorijum.findAll().forEach(fakture::add);
		return fakture;
	}
}
