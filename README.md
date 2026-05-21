# 🏦 Sistema Bancario en Java

## 📖 Descripción
Este proyecto es un sistema bancario desarrollado en Java utilizando programación orientada a objetos (POO).  
Permite la gestión de clientes y cuentas bancarias con diferentes tipos de operaciones financieras.

El sistema modela clientes individuales y empresas, y distintas cuentas como caja de ahorro, cuenta corriente y cuenta con convertibilidad a dólares.

---

## ⚙️ Funcionalidades principales

### 👤 Gestión de clientes
- Cliente individual (nombre, apellido, DNI)
- Cliente empresa (razón social, CUIT)

### 💳 Tipos de cuentas
- Caja de ahorro
- Cuenta corriente con giro en descubierto
- Cuenta con convertibilidad a dólares

### 💰 Operaciones bancarias
- Depósitos en pesos
- Extracciones en pesos
- Manejo de saldo disponible
- Uso de giro en descubierto
- Depósito de cheques
- Cobro de intereses en caja de ahorro
- Conversión de pesos a dólares
- Conversión de dólares a pesos

---

## 🧠 Modelo del sistema
El proyecto está estructurado con herencia y polimorfismo:

- `Cliente` (abstracta)
  - `ClienteIndividual`
  - `ClienteEmpresa`

- `Cuenta` (abstracta)
  - `CajaDeAhorro`
  - `CuentaCorriente`
  - `CuentaConvertibilidad`

Además se utiliza la clase:
- `Cheque`

---

## 🛠️ Tecnologías utilizadas
- Java
- Programación Orientada a Objetos (POO)
- Lombok
- Visual Studio Code

---

## 👤 Autor
- Pablo Vargas# TP_1_PABLOVARGAS
