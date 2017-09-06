package servis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PresekRepozitorijum;

@Service
public class PresekServis {

	@Autowired
	private PresekRepozitorijum presekRepozitorijum;
	
}
