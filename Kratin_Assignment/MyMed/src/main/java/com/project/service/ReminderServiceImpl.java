package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.project.pojos.UserCurrentRecord;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class ReminderServiceImpl {
	
	@Autowired
	UserCurrentRecordService recordService;
	
	
	@Scheduled(cron = "0 0 10 * * *") // Execute at 10 AM every day for reminding after BreakFast Medicine
    public void breakFast() {
		String medicine = "";
		//fetching only those current record which is going on.
		List<UserCurrentRecord> record = recordService.getAllRecordByStatus(true);
		for (UserCurrentRecord ucr : record) {
			if(ucr.getBreakFast()==1) 
			{
				medicine = medicine+" "+ucr.getMedicine();
			}
		}
		
        smsReminder(medicine);
        
    }

    @Scheduled(cron = "0 0 13 * * *") // Execute at 1 PM every day for reminding after Lunch Medicine
    public void lunch() {
    	String medicine = "";
    	//fetching only those current record which is going on.
        List<UserCurrentRecord> record = recordService.getAllRecordByStatus(true);
		for (UserCurrentRecord ucr : record) {
			if(ucr.getLunch()==1) 
			{
				medicine = medicine+" "+ucr.getMedicine();
			}
		}
		
        smsReminder(medicine);
        
    }

    @Scheduled(cron = "0 0 20 * * *") // Execute at 8 PM every day for reminding after Dinner Medicine
    public void dinner() {
        
    	String medicine = "";
    	//fetching only those current record which is going on.
    	List<UserCurrentRecord> record = recordService.getAllRecordByStatus(true);
		for (UserCurrentRecord ucr : record) {
			if(ucr.getDinner()==1) 
			{
				
				medicine = medicine+" "+ucr.getMedicine();
			}
		}
		
        smsReminder(medicine);
    }
    
//    -------------------------------------------------------------------
    
    
    // Your Twilio account credentials
    public static final String ACCOUNT_SID = "AC1236d520e72e1b1395a82b9184dd65ac261";
    public static final String AUTH_TOKEN = "123c8031f7c8a43b091402421f7d0b4273b";

    public static void smsReminder(String medicine){
    	
    	
    	
    	String messageBody ="Hello! This is a reminder to take your medicine. Your Medicine are as follows."+medicine;
        // Initialize the Twilio client
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        // Specify the sender and recipient phone numbers
        String fromNumber = "+13613011618";   
        String toNumber = "+917387979167";            

        // Send the SMS message
        Message message = Message.creator(
                new PhoneNumber(toNumber),
                new PhoneNumber(fromNumber),
                messageBody)
            .create();

        // Output the message SID if successful
        System.out.println("Message SID: " + message.getSid());
    }
    
    

}
