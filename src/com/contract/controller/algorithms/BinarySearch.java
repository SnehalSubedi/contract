/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.contract.controller.algorithms;

import com.contract.model.ContractModel;
import javax.swing.JOptionPane;
import java.util.List;

/**
 *
 * @author Snehal Subedi
 */

public class BinarySearch {

    // Generic binary search method
    public ContractModel searchByField(String searchValue, String searchColumn, List<ContractModel> contractList, int left, int right) {
        if (right < left) {
            return null; // Element not found
        }

        int mid = (left + right) / 2;

        // Get the value based on the selected column
        String midValue = getFieldValue(contractList.get(mid), searchColumn);

        // Handle numeric comparisons for Drone ID
        if (searchColumn.equals("Drone ID")) {
            try {
                int searchInt = Integer.parseInt(searchValue); // Convert the search value to an integer
                int midInt = Integer.parseInt(midValue); // Convert mid value (Drone ID) to integer

                if (searchInt == midInt) { // Match found
                    return contractList.get(mid);
                } else if (searchInt < midInt) { // Search left half
                    return searchByField(searchValue, searchColumn, contractList, left, mid - 1);
                } else { // Search right half
                    return searchByField(searchValue, searchColumn, contractList, mid + 1, right);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for Drone ID. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }

        // Default case (string comparison for other fields, if needed)
        int comparison = searchValue.compareToIgnoreCase(midValue);
        if (comparison == 0) { // Match found
            return contractList.get(mid);
        } else if (comparison < 0) { // Search left half
            return searchByField(searchValue, searchColumn, contractList, left, mid - 1);
        } else { // Search right half
            return searchByField(searchValue, searchColumn, contractList, mid + 1, right);
        }
    }

    // Helper method to fetch value based on selected column
    private String getFieldValue(ContractModel drone, String columnName) {
        switch (columnName) {
            case "Contract ID":
                return String.valueOf(drone.getContractId()); // Convert integer to string
            case "Title":
                return drone.getTitle();
            case "Type":
                return drone.getType();
            case "Term":
                return String.valueOf(drone.getTerm());
            case "Status":
                return drone.getStatus();
            case "StartDate":
                return drone.getStartDate();
            case "DraftedBy":
                return drone.getDraftedBy();
            case "ContactNo":
                return String.valueOf(drone.getContactNo());
            default:
                return ""; // Default case for unsupported columns
        }
    }
}