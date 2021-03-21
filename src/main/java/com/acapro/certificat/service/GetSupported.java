package com.acapro.certificat.service;

import java.util.List;

public interface GetSupported<ID, RESPONSE> {

     RESPONSE get(ID id);
     List<RESPONSE> getAll();
}
