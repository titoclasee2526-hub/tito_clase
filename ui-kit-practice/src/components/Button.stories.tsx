import type { Meta, StoryObj } from '@storybook/react';
import { Button } from './Button';


const meta: Meta<typeof Button> = {
  title: 'Componentes/Button',
  component: Button,
  tags: ['autodocs'],
};


export default meta;
type Story = StoryObj<typeof Button>;
export const Primary: Story = {
  args: {
    label: 'Acción Principal',
    variant: 'primary',
  },
};


export const DangerDisabled: Story = {
  args: {
    label: 'No Permitido',
    variant: 'danger',
    disabled: true,
  },
};
