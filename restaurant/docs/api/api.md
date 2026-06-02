# API

## Overview

Most endpoints require an authenticated session — see [security docs](../security/security.md) for the full list of public routes and role requirements.

`PUT` requests from HTML forms are sent as `POST` with a hidden `_method` field. This is handled by Spring's `HiddenHttpMethodFilter`, enabled in `application.yaml`.

Order-related endpoints proxy to a separate order-service running at `http://localhost:8081/api/v1/orders`.

---

## Authentication (`AuthenticationController`)

- `GET /register` — registration form *(public)*
- `POST /register` — submit registration → redirect `/login` *(public)*
- `GET /login` — login form *(public)*

---

## Index (`IndexController`)

- `GET /` — landing page with restaurant list *(public)*
- `GET /panel` — role-based router after login:
  - `ADMIN` → admin panel
  - `OWNER` → owner panel
  - `EMPLOYEE` → `/employees/panel`
  - `CUSTOMER` → `/home`

---

## Customers (`CustomerController`)

- `GET /home` — customer dashboard

---

## Employees (`EmployeeController`)

- `GET /employees/panel` — role-specific panel (MANAGER or WAITER view)
- `GET /employees` — list all employees; optional `?restaurantId=` filter
- `GET /employees/create` — create employee form
- `POST /employees` — submit new employee
- `GET /employees/{employeeId}` — view single employee

---

## Restaurants (`RestaurantController`)

- `GET /restaurants` — list all restaurants
- `GET /restaurants/create` — create restaurant form
- `POST /restaurants` — submit new restaurant
- `GET /restaurants/{id}/menus` — restaurant's menus *(public)*
- `GET /restaurants/{id}/employees` — restaurant's employees
- `GET /restaurants/{id}/reservations/new` — reservation form *(public)*
- `GET /restaurants/{id}/reservations` — restaurant's reservations
- `GET /restaurants/{id}/orders` — restaurant's orders (proxied from order-service)

---

## Menus (`MenuController`)

- `GET /menus` — list all menus *(ADMIN only)*
- `GET /menus/create` — create menu form; optional `?restaurantId=` pre-fill
- `POST /menus` — submit new menu
- `GET /menus/{menuId}` — view menu *(public)*
- `GET /menus/{menuId}/menu-items/add` — add item to menu form
- `POST /menus/{menuId}/menu-items/{menuItemId}` — add item to menu

---

## Menu Items (`MenuItemController`)

- `GET /menu-items` — list all menu items
- `GET /menu-items/create` — create menu item form
- `POST /menu-items` — submit new menu item

---

## Reservations (`ReservationController`)

- `POST /reservations` — create reservation *(public)*
- `GET /reservations` — list all reservations
- `GET /reservations/customers/{customerId}` — reservations by customer
- `PUT /reservations/{id}/status` — change reservation status

---

## Orders (`OrderController`)

- `GET /orders` — list all orders
- `PUT /orders/{orderId}/status` — change order status

---

## Users (`UserController`)

- `GET /users` — list all users *(ADMIN only)*
- `PUT /users/{email}/role` — change user role
