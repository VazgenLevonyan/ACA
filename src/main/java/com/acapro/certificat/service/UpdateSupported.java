package com.acapro.certificat.service;

public interface UpdateSupported<RESPONSE, REQUEST, ID> {

    RESPONSE update(REQUEST request, ID id);
}
