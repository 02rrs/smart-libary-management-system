package com.rishav.mapper;

import com.rishav.dto.BorrowRecordDto;
import com.rishav.model.BorrowRecord;

public class BoorrowRecordMapper {
	public static BorrowRecordDto toDto(BorrowRecord record) {
        if (record == null) return null;

        BorrowRecordDto dto = new BorrowRecordDto();
        dto.setBorrowDate(record.getBorrowDate());
        dto.setDueDate(record.getDueDate());
        dto.setReturnDate(record.getReturnDate());
        dto.setFineAmount(record.getFineAmount());
        dto.setStatus(record.getStatus());

        dto.setBookDto(BookMapper.toDto(record.getBook()));
        dto.setMemberDto(MemberMapper.toDto(record.getMember()));

        return dto;
    }
}
