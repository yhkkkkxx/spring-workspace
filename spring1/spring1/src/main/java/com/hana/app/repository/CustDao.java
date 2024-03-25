package com.hana.app.repository;

import com.hana.app.data.CustDto;
import com.hana.app.exception.DuplicatedIdException;
import com.hana.app.exception.IdNotFoundException;
import com.hana.app.exception.NotFoundException;
import com.hana.app.frame.Dao;

import java.util.ArrayList;
import java.util.List;

public class CustDao implements Dao<String, CustDto> {
    @Override
    public int insert(CustDto custDto) throws DuplicatedIdException {
        if(custDto.getId().equals("id01")) {
            throw new DuplicatedIdException("EX0001");
        }
        //System.out.println("Duplicated Id exception");
        System.out.println("Oracle DB: Inserted ..."+custDto);
        return 0;
    }

    @Override
    public int delete(String s) throws IdNotFoundException {
        if(!"id01".equals(s)) {
            throw new IdNotFoundException("EX0002");
        }
        System.out.println("Oracle DB: Deleted ..."+s);
        return 0;
    }

    @Override
    public int update(CustDto custDto) throws IdNotFoundException {
        if(!"id01".equals(custDto.getId())) {
            throw new IdNotFoundException("EX0003");
        }
        System.out.println("Oracle DB: Updated ..."+custDto);
        return 0;
    }

    @Override
    public CustDto select(String s) throws NotFoundException {
        if(!"id01".equals(s) && !"id02".equals(s) && !"id03".equals(s)) {
            throw new NotFoundException("EX0004");
        }
        return CustDto.builder().id(s).pwd("pwd1").name("james").build();
    }

    @Override
    public List<CustDto> select() throws NotFoundException {
        List<CustDto> list = new ArrayList<>();

        if(list.isEmpty()) {
            throw new NotFoundException("No data found");
        }
        list.add(CustDto.builder().id("id01").pwd("pwd01").name("james").build());
        list.add(CustDto.builder().id("id02").pwd("pwd02").name("james").build());
        list.add(CustDto.builder().id("id03").pwd("pwd03").name("james").build());
        return list;
    }
}
