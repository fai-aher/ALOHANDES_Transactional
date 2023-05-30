import random


def generar_inserts(nombre, cadena, repeticiones):
    columnas = cadena.split(", ")
    num_columnas = len(columnas)
    
    for i in range(repeticiones):
        valores = [str(i+1) for _ in range(num_columnas)]
        valores[1]=str(400001+int(valores[1]))
        stri=str(generar_fecha_aleatoria())
        valores[3]="to_date('"+stri+"','DD/MM/YYYY')"
        stri=str(generar_fecha_aleatoria())
        valores[4]="to_date('"+stri+"','DD/MM/YYYY')"
        stri=str(generar_fecha_aleatoria())
        valores[5]="to_date('"+stri+"','DD/MM/YYYY')"
        valores[6]="null"
        valores_str = ", ".join(valores)
        insert_statement = f"insert into {nombre} ({cadena}) values ({valores_str});"
        print(insert_statement)

def generar_fecha_aleatoria():
    dia = random.randint(1, 31)
    mes = random.randint(1, 12)
    anio = random.randint(2020, 2023)
    return f"{dia:02d}/{mes:02d}/{anio}"

# Ejemplo de uso
nombre_tabla = "reserva"
columnas = "IDCLIENTEASOCIADO, IDOFERTAASOCIADA, PROMOCIONESACTIVAS, FECHAINICIALRESERVA, FECHAFINALRESERVA, FECHARESERVA, FECHACANCELACION"
repeticiones = 200000

generar_inserts(nombre_tabla, columnas, repeticiones)