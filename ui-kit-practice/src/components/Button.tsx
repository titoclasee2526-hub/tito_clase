import React from 'react';
import './Button.css'; // Define aquí estilos básicos para las variantes


export interface ButtonProps {
  label: string;
  variant?: 'primary' | 'secondary' | 'danger';
  disabled?: boolean;
  onClick?: () => void;
}


export const Button = ({ label, variant = 'primary', disabled = false, onClick }: ButtonProps) => {
  return (
    <button
      className={`btn btn-${variant}`}
      disabled={disabled}
      onClick={onClick}
    >
      {label}
    </button>
  );
};
