import { Alert} from 'ui-components';
export function Prueba(){
    return(
        <>
        
        <Alert title={'Error'} type={'error'} description='Esto es un error'></Alert>
        <Alert title={'Warning'} type={'warning'} description='Esto es una advertencia' ></Alert>
        <Alert title={'Funcionando'} type={'success'} description='Esta funcionando'></Alert>
        
        </>
    )
}
