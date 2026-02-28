package com.example.demo.dto;

public class UserResponseDTO {

    private Long id;
    private String fullName;
    private String email;
    private String role;
    private Integer age;

    public UserResponseDTO() {}

    public UserResponseDTO(Long id, String fullName, String email, String role, Integer age) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.age = age;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}