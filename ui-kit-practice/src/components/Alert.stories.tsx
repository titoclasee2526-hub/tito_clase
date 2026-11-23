import type { Meta, StoryObj } from "@storybook/react-vite";
import { Alert } from "./Alert";

const meta: Meta<typeof Alert> = {
  title: 'Componentes/Alert',
  component: Alert,
  tags: ['autodocs'],
};

export default meta;
type Story = StoryObj<typeof Alert>;

export const Success: Story = {
  args: {
    title: 'Alerta',
    type: 'success',
    description: 'Esta es una alerta de éxito.',
  },
};      

export const Warning: Story = {
  args: {
    title: 'Advertencia',
    type: 'warning',
    description: 'Esta es una alerta de advertencia.',
  },
};

