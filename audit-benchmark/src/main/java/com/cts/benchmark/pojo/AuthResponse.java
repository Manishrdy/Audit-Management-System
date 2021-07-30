package com.cts.benchmark.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthResponse {
	private String uid;
	private boolean isValid;
	
	

}
