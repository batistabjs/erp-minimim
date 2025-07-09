package com.br.erp.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.br.erp.config.api.FeignConfig;

@FeignClient(url = "${CepApiUrl.url}", name = "CepApiClient", configuration = FeignConfig.class)
public interface ViaCep {
    
	@GetMapping(value = "/{cep}/json", produces = "application/json")
	ViaCepResponseDTO consultaCep(@PathVariable String cep);
}
