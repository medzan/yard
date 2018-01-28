package com.doc.spring.custom;

import java.util.Currency;
import java.util.Date;
import java.util.List;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.stereotype.Component;

@Component
public class CustomConverter {

	@CustomDataTime
	private Date customDate;

	@DateTimeFormat
	private Date date;
	private DefaultFormattingConversionService conversionService;

	public CustomConverter(DefaultFormattingConversionService conversionService) {
		this.conversionService = conversionService;
	}

	public Currency getCurrency(String currency) {
		Currency cur = conversionService.convert(currency, Currency.class);
		return cur;
	}

	public String[] getListStr(List<Integer> list) {
		Object result = conversionService.convert(list, TypeDescriptor.forObject(list),
				TypeDescriptor.array(TypeDescriptor.valueOf(String.class)));
		return (String[]) (result);
	}


	public Date getCustomDate() {
		return customDate;
	}

	public void setCustomDate(Date customDate) {
		this.customDate = customDate;
	}

	public Date getDate() {
		return conversionService.convert(date, Date.class);
//		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
