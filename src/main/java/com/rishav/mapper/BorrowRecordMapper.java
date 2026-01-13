package com.rishav.mapper;

import com.rishav.dto.BorrowRecordDto;
import com.rishav.model.BorrowRecord;

public class BorrowRecordMapper {
	private BorrowRecordMapper() {}
	
	public static BorrowRecordDto toDto(BorrowRecord record) {
        if (record == null) return null;

        BorrowRecordDto dto = new BorrowRecordDto();
        dto.setId(record.getId());
        dto.setBorrowDate(record.getBorrowDate());
        dto.setDueDate(record.getDueDate());
        dto.setReturnDate(record.getReturnDate());
        dto.setFineAmount(record.getFineAmount());
        dto.setStatus(record.getStatus());

        if (record.getBook() != null) {
            dto.setBookDto(BookMapper.toDto(record.getBook()));
        }
        
        if (record.getMember() != null) {
            dto.setMemberDto(MemberMapper.toDto(record.getMember()));
        }

        return dto;
    }
}
