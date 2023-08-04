package com.driver;

import java.util.Date;

public class mail {
        Date date;
        String snderId;
        String message;

        public mail(Date date, String sender, String message) {
            this.date=date;
            this.snderId=sender;
            this.message=message;
        }
    }

