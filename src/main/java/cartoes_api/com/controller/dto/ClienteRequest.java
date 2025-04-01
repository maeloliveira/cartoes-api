package cartoes_api.com.controller.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ClienteRequest {

   private Cliente cliente;

    public ClienteRequest(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Data
    public static class Cliente {
        public String name;
        public String cpf;
        public int age;
        public LocalDate birthDate;
        public String uf;
        public BigDecimal monthPayment;
        public String email;
        public String phone;

        public Cliente(String name, String cpf, int age, LocalDate birthDate, String uf, BigDecimal monthPayment, String email, String phone) {
            this.name = name;
            this.cpf = cpf;
            this.age = age;
            this.birthDate = birthDate;
            this.uf = uf;
            this.monthPayment = monthPayment;
            this.email = email;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
        }

        public String getUf() {
            return uf;
        }

        public void setUf(String uf) {
            this.uf = uf;
        }

        public BigDecimal getMonthPayment() {
            return monthPayment;
        }

        public void setMonthPayment(BigDecimal monthPayment) {
            this.monthPayment = monthPayment;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }


}
