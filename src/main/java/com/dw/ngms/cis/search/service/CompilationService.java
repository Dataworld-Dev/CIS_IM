package com.dw.ngms.cis.search.service;

import com.dw.ngms.cis.search.entity.Compilation;
import com.dw.ngms.cis.search.repository.CompilationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by swaroop on 2019/04/19.
 */
@Service
public class CompilationService {

    @Autowired
    private CompilationRepository compilationRepository;


    public List<Compilation> searchByCompilationNumberProvinceCode(String COMPILATION_NUMBER, String provinceCode) {
        return this.compilationRepository.searchByCompilationNumberProvinceCode(COMPILATION_NUMBER,provinceCode);
    }//searchByCompilationNumberProvinceCode


    public Compilation findByCompilationId(String compilationId) {
        return this.compilationRepository.findByCompilationId(compilationId);
    }






}
