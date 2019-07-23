package event.generator;

import java.io.StringWriter;
import java.time.LocalDateTime;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import event.model.Event;

@SuppressWarnings("restriction")
public class EventGenerator {
	
	/**
	 * 
	 * @param userid
	 * @param systemid
	 * @param name
	 * @param additionalInfo
	 * @param status
	 * @param createdby
	 * @param eventDateTime
	 * @param createdDateTime
	 * @return
	 * @throws JAXBException
	 */

	public String generateEvent(String userid, String systemid, String name, String additionalInfo, String status,
			String createdby, LocalDateTime eventDateTime, LocalDateTime createdDateTime) throws JAXBException {
		java.io.StringWriter sw = new StringWriter();
		JAXBContext contextObj = JAXBContext.newInstance(Event.class);

		Marshaller marshallerObj = contextObj.createMarshaller();
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshallerObj.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

		Event event = new Event();
		event.setUserid(userid);
		event.setSystemid(systemid);
		event.setName(name);
		event.setAdditionalinfo(additionalInfo);
		event.setStatus(status);
		event.setCreatedby(createdby);

		event.setEventdatetime(eventDateTime);
		event.setCreateddatetime(createdDateTime);
		marshallerObj.marshal(event, sw);
		return sw.toString();

	}

}
