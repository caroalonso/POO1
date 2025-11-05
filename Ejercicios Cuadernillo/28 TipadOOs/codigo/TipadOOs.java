package ejercicio28;

public class TipadOOs {
    public static void main(String[] args) {

        // 1️) A es una interfaz → se puede referenciar a objetos que la implementen (C o E)
        A objeto1 = new C();
        objeto1.mensajeInterface();

        A objeto2 = new E();
        objeto2.mensajeInterface();

        // 2️) B es abstracta → no se instancia se usa con clases hijas C y D
        B objeto3 = new C();
        objeto3.mensajeAbstracto();

        B objeto4 = new D();
        objeto4.mensajeAbstracto();

        // 3) D puede tener referencias a D o E (porque E hereda de D)
        D objeto5 = new D();
        objeto5.mensajeAbstracto();
        objeto5.mensajeParticular();

        D objeto6 = new E();
        objeto6.mensajeAbstracto();
        objeto6.mensajeParticular();

        // 4️) C concreto → tiene ambos métodos
        C objeto7 = new C();
        objeto7.mensajeAbstracto();
        objeto7.mensajeInterface();

        // 5️) Puede usarse tipo B o C para mensajeAbstracto()
        B objeto8 = new C();
        objeto8.mensajeAbstracto();

        C objeto9 = new C();
        objeto9.mensajeAbstracto();

        // 6️) Puede usarse tipo A o C para mensajeInterface()
        A objeto10 = new C();
        objeto10.mensajeInterface();

        C objeto11 = new C();
        objeto11.mensajeInterface();
    }
}

