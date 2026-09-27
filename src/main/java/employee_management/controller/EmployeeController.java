
package employee_management.controller;

import org.springframework.http.HttpStatus;
import employee_management.dto.EmployeeDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import employee_management.entity.Employee;
import employee_management.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping
    public EmployeeDTO addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeService.convertToEntity(employeeDTO);
        Employee savedEmployee = employeeService.saveEmployee(employee);

        return employeeService.convertToDTO(savedEmployee);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees()
                .stream()
                .map(employeeService::convertToDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return employeeService.convertToDTO(employee);
    }
    @GetMapping("/search")
    public List<EmployeeDTO> getEmployeesByName(@RequestParam String name) {
        return employeeService.getEmployeesByName(name)
                .stream()
                .map(employeeService::convertToDTO)
                .toList();
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
    @PutMapping("/{id}")
    public EmployeeDTO updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeDTO employeeDTO) {

        Employee employee = employeeService.convertToEntity(employeeDTO);
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);

        return employeeService.convertToDTO(updatedEmployee);
    }
    @GetMapping("/department/{department}")
    public List<EmployeeDTO> getEmployeesByDepartment(@PathVariable String department) {
        return employeeService.getEmployeesByDepartment(department)
                .stream()
                .map(employeeService::convertToDTO)
                .toList();
    }
    @GetMapping("/page")
    public Page<EmployeeDTO> getEmployeesWithPagination(Pageable pageable) {
        return employeeService.getEmployeesWithPagination(pageable)
                .map(employeeService::convertToDTO);
    }
}