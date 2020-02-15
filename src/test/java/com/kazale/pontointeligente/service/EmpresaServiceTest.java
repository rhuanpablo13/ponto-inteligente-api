package com.kazale.pontointeligente.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.kazale.pontointeligente.entities.Empresa;
import com.kazale.pontointeligente.repositories.EmpresaRepository;
import com.kazale.pontointeligente.services.EmpresaService;


@RunWith(SpringRunner.class)
@SpringBootTest
//@ActiveProfiles("test")
public class EmpresaServiceTest {

	@MockBean
	private EmpresaRepository empresaRepository;

	@Autowired
	private EmpresaService empresaService;

	private static final String CNPJ = "51463645000100";

	@Before
	public void setUp() throws Exception {
		BDDMockito.given(this.empresaRepository.findByCnpj(Mockito.anyString())).willReturn(new Empresa());
		BDDMockito.given(this.empresaRepository.save(Mockito.any(Empresa.class))).willReturn(new Empresa());
	}

	@Test
	public void testBuscarEmpresaPorCnpj() {
		Optional<Empresa> empresa = this.empresaService.buscarPorCnpj(CNPJ);
		System.out.println("**********************");
		System.out.println(empresa.toString());
		assertTrue(empresa.isPresent());
	}
	
	@Test
	public void testPersistirEmpresa() {
		Empresa emp = new Empresa();
		emp.setCnpj("11861136000102");
		emp.setDataAtualizacao(new Date());
		emp.setDataCriacao(new Date());
		emp.setRazaoSocial("Rhuan PC");
		
		//Empresa empresa = this.empresaService.persistir(new Empresa());
		Empresa empresa = this.empresaService.persistir(emp);

		assertNotNull(empresa);
	}

}