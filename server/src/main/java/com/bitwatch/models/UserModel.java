package com.bitwatch.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "User")
public class UserModel {

}
