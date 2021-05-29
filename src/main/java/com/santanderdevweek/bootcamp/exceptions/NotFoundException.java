package com.santanderdevweek.bootcamp.exceptions;

import com.santanderdevweek.bootcamp.util.MessageUtils;

public class NotFoundException extends RuntimeException{

    public NotFoundException (){
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
