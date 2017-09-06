package servis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StavkaFaktureRepozitorijum;

@Service
public class StavkaFaktureServis {

	@Autowired
	private StavkaFaktureRepozitorijum stavkaFaktureRepozitorijum;
	
}
