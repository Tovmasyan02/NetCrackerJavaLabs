package XmlAdapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import Classes.Division;
import ru.vsu.lab.entities.IDivision;

public class DivisionAdapter extends XmlAdapter<String,IDivision> {

	@Override
	public IDivision unmarshal(String v) throws Exception {
		return new Division(v);
	}

	@Override
	public String marshal(IDivision v) throws Exception {
		if(v!=null)
		return v.getName();
		return "not_D";
	}

}
