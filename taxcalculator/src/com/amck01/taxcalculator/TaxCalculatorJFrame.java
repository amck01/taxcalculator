package com.amck01.taxcalculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

public class TaxCalculatorJFrame extends JFrame {
	private JTextField price1;
	private JTextField price2;
	private JTextField price3;
	private JTextField price4;
	private JTextField price5;
	private JTextField price6;
	private JTextField price7;
	private JTextField totalPrice;
	private JButton btnComputeTotal;
	
	public final double TAX_RATE = 0.07;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaxCalculatorJFrame frame = new TaxCalculatorJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TaxCalculatorJFrame() {
		setTitle("Tax Calculator");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblEnterPrices = new JLabel("Enter prices:");
		GridBagConstraints gbc_lblEnterPrices = new GridBagConstraints();
		gbc_lblEnterPrices.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterPrices.gridx = 1;
		gbc_lblEnterPrices.gridy = 1;
		getContentPane().add(lblEnterPrices, gbc_lblEnterPrices);
		
		price1 = new JTextField();
		GridBagConstraints gbc_price1 = new GridBagConstraints();
		gbc_price1.insets = new Insets(0, 0, 5, 5);
		gbc_price1.anchor = GridBagConstraints.WEST;
		gbc_price1.gridx = 1;
		gbc_price1.gridy = 2;
		getContentPane().add(price1, gbc_price1);
		price1.setColumns(10);
		
		price2 = new JTextField();
		GridBagConstraints gbc_price2 = new GridBagConstraints();
		gbc_price2.insets = new Insets(0, 0, 5, 5);
		gbc_price2.anchor = GridBagConstraints.WEST;
		gbc_price2.gridx = 1;
		gbc_price2.gridy = 3;
		getContentPane().add(price2, gbc_price2);
		price2.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.insets = new Insets(0, 0, 5, 0);
		gbc_lblTotal.gridx = 7;
		gbc_lblTotal.gridy = 3;
		getContentPane().add(lblTotal, gbc_lblTotal);
		
		price3 = new JTextField();
		GridBagConstraints gbc_price3 = new GridBagConstraints();
		gbc_price3.insets = new Insets(0, 0, 5, 5);
		gbc_price3.anchor = GridBagConstraints.WEST;
		gbc_price3.gridx = 1;
		gbc_price3.gridy = 4;
		getContentPane().add(price3, gbc_price3);
		price3.setColumns(10);
		
		JLabel lblTaxRate = new JLabel("Tax Rate: 7%");
		GridBagConstraints gbc_lblTaxRate = new GridBagConstraints();
		gbc_lblTaxRate.insets = new Insets(0, 0, 5, 5);
		gbc_lblTaxRate.gridx = 4;
		gbc_lblTaxRate.gridy = 4;
		getContentPane().add(lblTaxRate, gbc_lblTaxRate);
		
		totalPrice = new JTextField();
		GridBagConstraints gbc_totalPrice = new GridBagConstraints();
		gbc_totalPrice.insets = new Insets(0, 0, 5, 0);
		gbc_totalPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_totalPrice.gridx = 7;
		gbc_totalPrice.gridy = 4;
		getContentPane().add(totalPrice, gbc_totalPrice);
		totalPrice.setColumns(10);
		
		price4 = new JTextField();
		GridBagConstraints gbc_price4 = new GridBagConstraints();
		gbc_price4.insets = new Insets(0, 0, 5, 5);
		gbc_price4.anchor = GridBagConstraints.WEST;
		gbc_price4.gridx = 1;
		gbc_price4.gridy = 5;
		getContentPane().add(price4, gbc_price4);
		price4.setColumns(10);
		
		price5 = new JTextField();
		GridBagConstraints gbc_price5 = new GridBagConstraints();
		gbc_price5.insets = new Insets(0, 0, 5, 5);
		gbc_price5.anchor = GridBagConstraints.WEST;
		gbc_price5.gridx = 1;
		gbc_price5.gridy = 6;
		getContentPane().add(price5, gbc_price5);
		price5.setColumns(10);
		
		btnComputeTotal = new JButton("Compute Total");
		btnComputeTotal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				double[] prices = {Double.parseDouble(price1.getText()), Double.parseDouble(price2.getText()), Double.parseDouble(price3.getText()), Double.parseDouble(price4.getText()),
						Double.parseDouble(price5.getText()), Double.parseDouble(price6.getText()), Double.parseDouble(price7.getText())};
			
				double total = computeTotal(prices);
				totalPrice.setText(String.format("%.2f", total));
			}
		});
		GridBagConstraints gbc_btnComputeTotal = new GridBagConstraints();
		gbc_btnComputeTotal.insets = new Insets(0, 0, 5, 5);
		gbc_btnComputeTotal.gridx = 4;
		gbc_btnComputeTotal.gridy = 6;
		getContentPane().add(btnComputeTotal, gbc_btnComputeTotal);
		
		price6 = new JTextField();
		GridBagConstraints gbc_price6 = new GridBagConstraints();
		gbc_price6.insets = new Insets(0, 0, 5, 5);
		gbc_price6.anchor = GridBagConstraints.WEST;
		gbc_price6.gridx = 1;
		gbc_price6.gridy = 7;
		getContentPane().add(price6, gbc_price6);
		price6.setColumns(10);
		
		price7 = new JTextField();
		GridBagConstraints gbc_price7 = new GridBagConstraints();
		gbc_price7.insets = new Insets(0, 0, 0, 5);
		gbc_price7.anchor = GridBagConstraints.WEST;
		gbc_price7.gridx = 1;
		gbc_price7.gridy = 8;
		getContentPane().add(price7, gbc_price7);
		price7.setColumns(10);

	}
	
	
	public double computeTotal(double[] prices) {
		
		double total = 0;
		
		for (int i = 0; i < prices.length; i++) {
			total += prices[i];
		}
		
		total += (total * TAX_RATE);
		
		return total;
	}
}
