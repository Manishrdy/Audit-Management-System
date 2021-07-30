package com.cognizant.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Questions {
	
	public List<QuestionsEntity> getQuestionsEntity() {
		return questionsEntity;
	}

	public void setQuestionsEntity(List<QuestionsEntity> questionsEntity) {
		this.questionsEntity = questionsEntity;
	}

	private List<QuestionsEntity> questionsEntity;
}