package com.yhsong.caresoft_interface;

public interface HIPAAComplianceUser {
    abstract boolean assignPin(int pin);
    abstract boolean accessAuthorized(Integer confirmedAuthID);
}