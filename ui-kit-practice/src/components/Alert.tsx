import React from 'react';
import './Alert.css'; // Define aquí estilos básicos para las variantes

export interface AlertProps {
  title: string;
  type: 'success' | 'warning' | 'error';
  description?: string;
}

export const Alert = ({title, type = 'success', description}: AlertProps) => {
  return (
    <div className={`alert alert-${type}`}>
      <strong>{title}</strong>
      {description && <p>{description}</p>}
    </div>
  );
}