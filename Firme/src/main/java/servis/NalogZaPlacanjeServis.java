package servis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.NalogZaPlacanjeRepozitorijum;
import model.NalogZaPlacanje;

@Service
public class NalogZaPlacanjeServis {

	@Autowired
	private NalogZaPlacanjeRepozitorijum nalogZaPlacanjeRepozitorijum;
	
	public void NoviNalogZaPlacanje(NalogZaPlacanje nalog){
		nalogZaPlacanjeRepozitorijum.save(nalog);
	}
	
	public List<NalogZaPlacanje> nadjiSveNalogeZaPlacanje(){
		List<NalogZaPlacanje> nalozi = new ArrayList<>();
		nalogZaPlacanjeRepozitorijum.findAll().forEach(nalozi::add);
		return nalozi;
	}
}
