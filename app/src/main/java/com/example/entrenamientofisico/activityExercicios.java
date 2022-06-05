package com.example.entrenamientofisico;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.entrenamientofisico.db.dbinsert;

public class activityExercicios extends AppCompatActivity {

    private LinearLayout linear1;
    private TextView titulo, descripcion, tituloEjercicio, countExercices;
    private Button botonRecorrer, botonRetroceder, salirMain;
    int numEjercicio = 0, countLevel = 0;
    private ImageView imag;

    String indexTitle[] = {
            "Abdominales - pricipiante",
            "Abdominales - intermedio",
            "Abdominales - avanzado",
            "Espalda y hombros - pricipiante",
            "Espalda y hombros - intermedio",
            "Espalda y hombros - avanzado",
            "Pecho - pricipiante",
            "Pecho - intermedio",
            "Pecho - avanzado",
            "Brazo - pricipiante",
            "Brazo - intermedio",
            "Brazo - avanzado",
            "Pierna - pricipiante",
            "Peirna - intermedio",
            "Pierna - avanzado"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicios);

        titulo = (TextView) findViewById(R.id.tituloEjercicio);
        tituloEjercicio = (TextView) findViewById(R.id.nombreEjercicio);
        descripcion = (TextView) findViewById(R.id.descripcionEjercicio);
        countExercices = (TextView) findViewById(R.id.repsTime);
        imag = (ImageView) findViewById(R.id.image_ex);
        linear1 = (LinearLayout) findViewById(R.id.linearcontentvalues);

        Bundle getValue = getIntent().getExtras();
        int valueCat = getValue.getInt("value");
        int numCategoria = valueCat;

        String abdominales[][] = {
                {"Saltos De Tijera","Comienzo con los pies juntos y los brazos a los lados; a continuación, salta con los pies separados y las manos sobre la cabeza. Vuelve a la posición original y realiza la siguiente repetición. Este ejercicio sirve para entrenar todo el cuerpo y trabaja todos los grandes grupos musculares.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "20s"},
                {"Crunch Abdominales","Túmbate boca arriba con las rodillas flexionadas y los brazos extendidos hacia delante. A continuación, levanta el tren superior del suelo. Aguanta unos segundos y vuelve a la posición original lentamente. Sobre todo, se trabajan el músculo del recto del abdomen y los oblicuos.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x16"},
                {"Twist (ruso)","Siéntate en el suelo con las rodillas flexionadas, los pies ligeramente levantados y la espalda inclinada hacia atrás. A continuación, une las manos y gira de un lado a otro.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x20"},
                {"Elevaciones de Piernas","Túmbate de espaldas y coloca las manos debajo de las caderas a modo de apoyo. Luego eleva las piernas rectas hasta formar un ángulo recto con el suelo. Baja las piernas despacio y vuelve a repetir.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x16"},
                {"Tablón","Túmbate apoyando los dedos de los pies y los antebrazos en el suelo. Mantén el cuerpo recto y quédate en esta posición el tiempo que puedas. Los tablones fortalecen los abdominales, la espalda y los hombros.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "20s"},
                {"Estiramiento de cobra","Túmbate boca abajo, dobla los codos y coloca las manos por debajo de los hombros. A continuación, levanta el pecho del suelo tanto como puedas. Mantén la posición durante unos segundos.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "30s"},
                {"Flexión y Rotación","Comienza en la posición de flexión. A continuación, baja para realizar una flexión y al subir, rota el tren superior y extiende el brazo derecho hacia arriba. Repite el ejercicio con el otro brazo. Este ejercicio es genial para el pecho, los hombros. los brazos y el torso.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x12"},
                {"Crunch de Bicicleta","Túmbate recto en el suelo, con las manos sujetando loa cabeza, levanta las rodillas y realice un movimiento de pedaleo, tocando los codos con la rodilla contraria mientras vas girando hacia delante y atrás.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x12"},
                {"Butt Bridge","Túmbate en el suelo y encoge las rodillas con los pies sobre el suelo. Pon los brazos extendidos sobre el suelo. Después, sube el trasero todo lo que puedas, como si fueras un puente.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x30"},
                {"Abdominal en V","Túmbate boca arriba con las piernas y los brazos extendidos, y las piernas juntas. Levanta el tronco y las piernas, utiliza los brazos para tocar los de dos de los pies y, a continuación, vuelve a la posición original y repite el ejercicio.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x15"},
                {"Descanso", "Terminaeste la ronda de ejercios.\nTomate unos minutos para descansar, recuerda tomar suficiente agua.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "10"}
        };

        String espaldaHombros[][] = {
                {"Saltos De Tijera", "Comienza con los pies juntos y los brazos a los lados; a continuación, salta con los pies separados y las manos sobre la cabeza. Vuelve a la posición original y realiza la siguiente repetición. Este ejercicio sirve para entrenar todo el cuerpo y trabaja todos los grandes grupos musculares.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "20s"},
                {"Hiperextensión", "Túmbate boca abajo con los dedos de los pies tocando el suelo y la barbilla en las manos. Levanta el pecho del suelo tanto como puedas. Mantén esta posición durante unos segundos y vuelve a la posición original.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x12"},
                {"Flexiones en pica", "Empieza con las manos y los pies en el suelo. Alinea las manos con los hombros. Dobla el cuerpo y levanta las caderas en forma de «V» invertida. Flexiona los codos y acerca la cabeza al suelo. Haz fuerza para volver a la posición original y repite el ejercicio.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x10"},
                {"Flexiones Inversas", "Comienza en la posición habitual para flexiones. Empuja tu cuerpo hacia abajo, luego flexiona las rodillas y presiona tus caderas hacia atrás con los brazos rectos. Vuelve a la posición inicial y repite el ejercicio.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x10"},
                {"Inchworms", "Empieza con los pies alineados con los hombros. Inclina el cuerpo y coloca las manos Io más lejos que puedas frente a ti. A continuación, retrocede con las manos. Repite el ejercicio.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x14"},
                {"Estiramiento Izquierdo", "Estiramiento tumbado sobre el costado İzquierdo Apóyate sobre el lado derecho con la pierna derecha ligeramente flexionada frente a ti y la pierna izquierda estirada detrás de la pierna derecha. Estira el brazo izquierdo por encima de la cabeza y tira suavemente de tu muñeca Izquierda para estirar el lado izquierdo de tu Cuerpo. Mantén esta posición durante unos segundos.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "30s"},
                {"Estiramiento Derecho", "Estiramiento tumbado sobre el costado derecho Apóyate sobre el lado izquierdo con la pierna izquierda ligeramente flexionada frente a ti y la pierna derecha estirada detrás de la pierna izquierda. Estira el brazo derecho por encima de la cabeza y tira suavemente de tu muñeca derecha para estirar el lado derecho de tu cuerpo. Mantén esta posición durante unos segundos.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "30s"},
                {"Postura de Bebé", "Comienza con las rodillas y las manos en el suelo. Coloca las manos un poco adelantadas, abre las rodillas y junta las puntas de los pies. Inspira, espira y siéntate sobre las rodillas. Intenta que tu trasero toque los talones. Relaja los codos, toca el suelo con la frente e intenta bajar el pecho hasta el suelo. Mantén esta posición.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "30s"},
                {"Elevaciones de Y ", "Túmbate boca abajo con los brazos totalmente extendidos y los pulgares hacia arriba. Tu cuerpo debería tener la forma de la letra «Y». Levanta los brazos del suelo tanto como puedas y mantén la posición durante 2 segundos. Vuelve lentamente a la posición original y repite el ejercicio.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x14"},
                {"Flexión supina ", "Túmbate boca arriba con los pies apoyados en el suelo y los brazos doblados a ambos lados. Levanta el pecho tanto como puedas y, a continuación, vuelve lentamente a la posición original. Repite el ejercicio. ", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x12"},
                {"Descanso", "Terminaeste la ronda de ejercios.\nTomate unos minutos para descansar, recuerda tomar suficiente agua.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "10"}

        };

        String pecho[][] = {
                {"Burpees", "Comienza de pie. Baja y mantén la posición de sentadilla y pon las manos en el suelo. Estira las piernas y brazos a la vez. Vuelve de inmediato a la posición de sentadilla. Salta desde la posición de sentadilla. Los burpees son ejercicios que trabajan todo el cuerpo con ejercicio aeróbico y de fuerza.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x10"},
                {"Flexiones Escalonadas", "Comienza en posición de flexión, pero con una mano delante de la otra. Realiza una flexión y cambia la mano que va delante. Recuerda mantener el torso en línea recta.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x12"},
                {"Flexiones Hindúes", "Comienza con manos y pies tocando el suelo mientras flexionas las caderas en el aire. Como una invertida .Luego flexiona los codos de forma que tu cuerpo pueda bajar hacia el suelo. Cuando el cuerpo se acerque al suelo, eleva la parte superior del cuerpo lo máximo posible. Vuelve a la posición de inicio y repite.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x14"},
                {"Flexiones en Diamante", "Comienza en posición para hacer flexiones. Luego crea una forma de diamante debajo del pecho juntando los dedos índices y pulgares y luego presiona el cuerpo arriba y abajo. Recuerda mantener el torso en línea recta.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x16"},
                {"Flexiones en Caja", "Comienza a cuatro patas con las rodillas a la altura de las caderas y las manos justo debajo de los hombros. Flexiona los codos y realiza una flexión. Vuelve a la posición de inicio y repite.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x12"},
                {"Flexiones Spiderman", "Comienza en la posición habitual para flexiones. Mientras presionas el torso hacia abajo, flexiona y eleva la pierna hacia un lateral. Vuelve a la posición de inicio y repite cambiando de lado. Recuerda mantener el torso en línea recta.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x10"},
                {"Flexiones con Inclinación", "(Apoyo de Piernas) Comienza a cuatro patas con las rodillas a la altura de las caderas y las manos debajo de los hombros. Luego coloca los pies en alto en una silla o bancoy empuja el cuerp0 arriba y abajo principalmente con la fuerza de los brazos. Recuerda mantener el torso en línea recta.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x12"},
                {"Estiramiento de Hombros", "Coloca un brazo entrecruzado con tu cuerpo, paralelo al suelo, y a continuación utiliza el otro brazo para tirar del brazo en paralelo en dirección al pecho. Mantén un rato la posición, cambia de brazo y repite el ejercicio.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "30s"},
                {"Flexión y Rotación ", "Comienza en la posición de flexión. A continuación, baja para realizar una flexión y al subir, rota el tren superior y extiende el brazo derecho hacia arriba. Repite el ejercicio con el otro brazo. Este ejercicio es genial para el pecho, los hombros, los brazos y el torso.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x12"},
                {"Estiramiento de cobra ", "Túmbate boca abajo, dobla los codos y coloca las manos por debajo de los hombros. A continuación, levanta el pecho del suelo tanto como puedas. Mantén la posición durante unos segundos.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "30s"},
                {"Descanso", "Terminaeste la ronda de ejercios.\nTomate unos minutos para descansar, recuerda tomar suficiente agua.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "10"}
        };

        String brazo[][] = {
                {"Burpees", "Comienza de pie. Baja y mantén la posición de sentadilla y pon las manos en el suelo. Estira las piernas y brazos a la vez. Vuelve de inmediato a la posición de sentadilla. Salta desde la posición de sentadilla. Los burpees son ejercicios que trabajan todo el cuerpo con ejercicio aeróbico y de fuerza.", "https://media3.giphy.com/media/U9t3B88WPKmxvD1bbN/giphy.gif", "x16"},
                {"Flexión de bíceps izquierdo", "Túmbate sobre tu lado izquierdo con las rodillas dobladas y levantadas. Agarra el muslo izquierdo con la mano izquierda y coloca la mano derecha detrás de la cabeza. A continuación, eleva la parte superior del cuerpo tirando del muslo izquierdo. Repite el ejercicio.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x12"},
                {"Flexión de bíceps derecho", "Túmbate sobre tu lado derecho con las rodillas dobladas y levantadas. Agarra el muslo derecho con la mano derecha y coloca la mano izquierda detrás de la cabeza. A continuación, eleva la parte superior del cuerpo tirando del muslo derecho. Repite el ejercicio.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x12"},
                {"Tríceps en Suelo", "Siéntate en el suelo con las rodillas flexionadas y las plantas de los pies apoyadas en el suelo. Pon las manos a la altura de los hombros con los dedos apuntando hacia las caderas. Levanta las caderas del suelo. Luego contrae y estira los codos de forma que te permita levantar y bajar las caderas. Repite el ejercicio para fortalecer la parte superior de los brazos.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x16"},
                {"Ganchos alternos", "Colócate en pie con los pies separados el ancho de los hombros, y el pie dominante ligeramente avanzado. Dobla un poco las rodillas, cierra los puños y dobla los codos 90 grados. Eleva el brazo derecho a la altura del hombro y mantén el antebrazo en paralelo al suelo. Gira los hombros y las caderas y lanza un puñetazo hacia la izquierda. Cambia de lado y repite.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "30s"},
                {"Fondos militares", "Comienza en una posición de fondo con las manos directamente debajo de los hombros, los codos próximos al cuerpo y los pies separados a una distancia no superior a 30 centímetros. Dobla los codos y baja el cuerpo hasta que la parte superior de los brazos esté paralela al suelo. Permanece en esta posición durante un segundo y luego eleva el cuerpo de vuelta a la posición inicial y repite el ejercicio.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x14"},
                {"Giro de hombros", "Colócate en pie con las manos detrás de las orejas y los codos hacia afuera. Gira los codos hasta que ambos apunten al frente.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "x16"},
                {"Circulo con los brazos", "Colocate de pie con los brazos extendidos hacia los lados a la altura de los hombros. Mueve los brazos con rapidez en circulos y en la direccion de las agujas del reloj.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "30s"},
                {"Estiramiento de tríceps derecho ", "Coloca la mano derecha en la espalda, utiliza la mano izquierda para agarrar el codo derecho y tira de él suavemente. Mantén esta posición durante unos segundos.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "30s"},
                {"Estiramiento de tríceps izquierdo ", "Coloca la mano izquierda en la espalda, utiliza la mano derecha para agarrar el codo izquierdo y tira de él suavemente. Mantén esta posición durante unos segundos.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "30s"},
                {"Descanso", "Terminaeste la ronda de ejercios.\nTomate unos minutos para descansar, recuerda tomar suficiente agua.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "10"}
        };

        String pierna[][] = {
                {"Saltos explosivos de rodillas", "Ponte de rodillas, con ayuda de tus piernas genera explosividad para ponerte de pie. Repite el ejercicio.", "https://media4.giphy.com/media/XKHiFqVMvCCpnvkaMf/giphy.gif", "x6"},
                {"Pistol squats cada pierna", "Comience de pie con los pies separados al ancho de los hombros. Póngase en cuclillas sobre ambas piernas hasta que esté lo más bajo que pueda sostener, luego levante un pie del suelo. Luego, regresa a la posición inicial. Repita el ejercicio en ambas piernas.", "https://media4.giphy.com/media/LTWejllpSno2fVvxqO/giphy.gif", "x5"},
                {"Caminata de pato", "Ponte en posición de sentadilla profunda, separa los pies poco más allá del ancho de la cadera y descendemos glúteos siempre con espalda recta hasta que nuestras rodillas formen un ángulo inferior a los 90°. Inicia el desplazamiento despegando y adelantando un pie hasta que los muslos queden paralelos al suelo.", "https://media4.giphy.com/media/ikAi8zVbeTa1NHlTOk/giphy.gif", "10m"},
                {"Saltos explosivos de pie", "Ponte de pie, salta lo más alto que puedas intentando tocar tus rodillas con tus pectorales. Repite el ejercicio", "https://media0.giphy.com/media/xjXqSc7yoSj9h76DAe/giphy.gif", "x10"},
                {"Inclinaciones hacia adelante", "Sujétate de algún objeto con una  mano, inclínate hacia adelante flexionando las rodillas pero sin llegar a tocar el suelo. Repite el ejercicio.", "https://media3.giphy.com/media/O2WI1FvPAjGtgiiORv/giphy.gif", "x8"},
                {"Zancadas laterales", "Colócate de pie, con los pies paralelo, desplazar una pierna hacia el lateral y apoyar completamente el pie en el piso mientras flexionamos la rodilla y descendemos el cuerpo. Repite hacia el otro lado.", "https://media4.giphy.com/media/ORp0Y4ZrJo4PAdrGv2/giphy.gif", "x4"},
                {"Caminata de pato", "Ponte en posición de sentadilla profunda, separa los pies poco más allá del ancho de la cadera y descendemos glúteos siempre con espalda recta hasta que nuestras rodillas formen un ángulo inferior a los 90°. Inicia el desplazamiento despegando y adelantando un pie hasta que los muslos queden paralelos al suelo.", "https://media4.giphy.com/media/ikAi8zVbeTa1NHlTOk/giphy.gif", "10m"},
                {"Wall sit con un pie", "Apóyate contra la pared con los pies firmemente plantados en el suelo, separados al ancho de los hombros. Simula estar sentado recargando tu espalda pon la pared formando un ángulo de recto. Levanta un pie a la altura de la otra rodilla mantenla por un tiempo. Repite en ambas piernas.",  "https://media1.giphy.com/media/ekku6uBiagwDh1iY8g/200.webp", "5s"},
                {"Sentadillas profundas explosivas", "Comienzan con los pies por fuera de las caderas y las rodillas en la misma dirección que las puntas de los pies. Luego echamos la cadera hacia atrás y flexionamos las caderas en 90 grados, saltamos en vertical con toda nuestra energía. Repite el ejercicio.", "https://media2.giphy.com/media/sqhvc1lfawKXEEXcIn/200.webp", "x10"},
                {"Saltos explosivos de pie", "Ponte de pie, salta lo más alto que puedas intentando tocar tus rodillas con tus pectorales. Repite el ejercicio", "https://media0.giphy.com/media/xjXqSc7yoSj9h76DAe/giphy.gif", "x10"},
                {"Descanso", "Terminaeste la ronda de ejercios.\nTomate unos minutos para descansar, recuerda tomar suficiente agua.", "https://fernando-leon.github.io/urlsAnimation/gif1.gif", "10"}
        };


        int principiante = 1;
        int intermedio = 2;
        int avanzado = 3;


        for(int i=1; i<=15; i+=1) {
            if(valueCat == i){
                titulo.setText(indexTitle[i-1]);
            }
        }

        //Salir del ejercicio

        salirMain = (Button) findViewById(R.id.salirToMain);

        salirMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitToMain();
            }
        });

        //Pasar al siguiente ejercicio

        botonRecorrer = (Button) findViewById(R.id.siguiente);

        //Cambio de estado boton

        if(numEjercicio == 0 && countLevel == 0){
            botonRecorrer.setText("Iniciar");
        }

        botonRecorrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri urlparse = null;
                linear1.setVisibility(View.VISIBLE);

                botonRecorrer.setText("Siguiente");

                if(numEjercicio > 0){
                    botonRetroceder.setVisibility(View.VISIBLE);
                    linear1.setVisibility(View.VISIBLE);
                }

                if(numEjercicio == 10 || numEjercicio == 0){
                    botonRetroceder.setVisibility(View.INVISIBLE);
                }

                if(numEjercicio == 10){
                    botonRecorrer.setText("Continuar");
                    linear1.setVisibility(View.INVISIBLE);
                }

                if((numEjercicio == 9 && (valueCat == 1 || valueCat == 4 || valueCat == 7 || valueCat == 10 || valueCat == 13)) || numEjercicio == 9 && countLevel == 1 || numEjercicio == 9 && countLevel == 2){
                    botonRecorrer.setText("Finalizar");
                }

                //Abdominales

                if(valueCat == 1){
                    if(numEjercicio < abdominales.length){
                        numEjercicio++;
                        tituloEjercicio.setText(abdominales[numEjercicio-1][0]);
                        descripcion.setText(abdominales[numEjercicio-1][1]);
                        urlparse = Uri.parse(abdominales[numEjercicio-1][2]);
                        countExercices.setText(abdominales[numEjercicio-1][3]);
                    }
                    if(numEjercicio == abdominales.length){
                        countLevel++;
                        if(countLevel == principiante){
                            register();
                        }
                    }
                }

                if(valueCat == 2){
                    if(numEjercicio < abdominales.length){
                        numEjercicio++;
                        tituloEjercicio.setText(abdominales[numEjercicio-1][0]);
                        descripcion.setText(abdominales[numEjercicio-1][1]);
                        urlparse = Uri.parse(abdominales[numEjercicio-1][2]);
                        countExercices.setText(abdominales[numEjercicio-1][3]);
                    }
                    if(numEjercicio == abdominales.length){
                        countLevel++;
                        if (countLevel == intermedio ){
                            register();
                        }else {
                            numEjercicio = 0;
                        }
                    }
                }

                if(valueCat == 3){
                    if(numEjercicio < abdominales.length){
                        numEjercicio++;
                        tituloEjercicio.setText(abdominales[numEjercicio-1][0]);
                        descripcion.setText(abdominales[numEjercicio-1][1]);
                        urlparse = Uri.parse(abdominales[numEjercicio-1][2]);
                        countExercices.setText(abdominales[numEjercicio-1][3]);
                    }
                    if(numEjercicio == abdominales.length){
                        countLevel++;
                        if (countLevel == avanzado ){
                            register();
                        }else {
                            numEjercicio = 0;
                        }
                    }
                }

                //Espalda y hombros

                if(valueCat == 4){
                    if(numEjercicio < espaldaHombros.length){
                        numEjercicio++;
                        tituloEjercicio.setText(espaldaHombros[numEjercicio-1][0]);
                        descripcion.setText(espaldaHombros[numEjercicio-1][1]);
                        urlparse = Uri.parse(espaldaHombros[numEjercicio-1][2]);
                        countExercices.setText(espaldaHombros[numEjercicio-1][3]);
                    }
                    if(numEjercicio == espaldaHombros.length){
                        countLevel++;
                        if(countLevel == principiante){
                            register();
                        }
                    }
                }

                if(valueCat == 5){
                    if(numEjercicio < espaldaHombros.length){
                        numEjercicio++;
                        tituloEjercicio.setText(espaldaHombros[numEjercicio-1][0]);
                        descripcion.setText(espaldaHombros[numEjercicio-1][1]);
                        urlparse = Uri.parse(espaldaHombros[numEjercicio-1][2]);
                        countExercices.setText(espaldaHombros[numEjercicio-1][3]);
                    }
                    if(numEjercicio == espaldaHombros.length){
                        countLevel++;
                        if (countLevel == intermedio ){
                            register();
                        }else {
                            numEjercicio = 0;
                        }
                    }
                }

                if(valueCat == 6){
                    if(numEjercicio < espaldaHombros.length){
                        numEjercicio++;
                        tituloEjercicio.setText(espaldaHombros[numEjercicio-1][0]);
                        descripcion.setText(espaldaHombros[numEjercicio-1][1]);
                        urlparse = Uri.parse(espaldaHombros[numEjercicio-1][2]);
                        countExercices.setText(espaldaHombros[numEjercicio-1][3]);
                    }
                    if(numEjercicio == espaldaHombros.length){
                        countLevel++;
                        if (countLevel == avanzado ){
                            register();
                        }else {
                            numEjercicio = 0;
                        }
                    }
                }

                //Pecho

                if(valueCat == 7){
                    if(numEjercicio < pecho.length){
                        numEjercicio++;
                        tituloEjercicio.setText(pecho[numEjercicio-1][0]);
                        descripcion.setText(pecho[numEjercicio-1][1]);
                        urlparse = Uri.parse(pecho[numEjercicio-1][2]);
                        countExercices.setText(pecho[numEjercicio-1][3]);
                    }
                    if(numEjercicio == pecho.length){
                        countLevel++;
                        if(countLevel == principiante){
                            register();
                        }
                    }
                }

                if(valueCat == 8){
                    if(numEjercicio < pecho.length){
                        numEjercicio++;
                        tituloEjercicio.setText(pecho[numEjercicio-1][0]);
                        descripcion.setText(pecho[numEjercicio-1][1]);
                        urlparse = Uri.parse(pecho[numEjercicio-1][2]);
                        countExercices.setText(pecho[numEjercicio-1][3]);
                    }
                    if(numEjercicio == pecho.length){
                        countLevel++;
                        if (countLevel == intermedio ){
                            register();
                        }else {
                            numEjercicio = 0;
                        }
                    }
                }

                if(valueCat == 9){
                    if(numEjercicio < pecho.length){
                        numEjercicio++;
                        tituloEjercicio.setText(pecho[numEjercicio-1][0]);
                        descripcion.setText(pecho[numEjercicio-1][1]);
                        urlparse = Uri.parse(pecho[numEjercicio-1][2]);
                        countExercices.setText(pecho[numEjercicio-1][3]);
                    }
                    if(numEjercicio == pecho.length){
                        countLevel++;
                        if (countLevel == avanzado ){
                            register();
                        }else {
                            numEjercicio = 0;
                        }
                    }
                }

                //Brazo

                if(valueCat == 10){
                    if(numEjercicio < brazo.length){
                        numEjercicio++;
                        tituloEjercicio.setText(brazo[numEjercicio-1][0]);
                        descripcion.setText(brazo[numEjercicio-1][1]);
                        urlparse = Uri.parse(brazo[numEjercicio-1][2]);
                        countExercices.setText(brazo[numEjercicio-1][3]);
                    }
                    if(numEjercicio == brazo.length){
                        countLevel++;
                        if(countLevel == principiante){
                            register();
                        }
                    }
                }

                if(valueCat == 11){
                    if(numEjercicio < brazo.length){
                        numEjercicio++;
                        tituloEjercicio.setText(brazo[numEjercicio-1][0]);
                        descripcion.setText(brazo[numEjercicio-1][1]);
                        urlparse = Uri.parse(brazo[numEjercicio-1][2]);
                        countExercices.setText(brazo[numEjercicio-1][3]);
                    }
                    if(numEjercicio == brazo.length){
                        countLevel++;
                        if (countLevel == intermedio ){
                            register();
                        }else {
                            numEjercicio = 0;
                        }
                    }
                }

                if(valueCat == 12){
                    if(numEjercicio < brazo.length){
                        numEjercicio++;
                        tituloEjercicio.setText(brazo[numEjercicio-1][0]);
                        descripcion.setText(brazo[numEjercicio-1][1]);
                        urlparse = Uri.parse(brazo[numEjercicio-1][2]);
                        countExercices.setText(brazo[numEjercicio-1][3]);
                    }
                    if(numEjercicio == brazo.length){
                        countLevel++;
                        if (countLevel == avanzado ){
                            register();
                        }else {
                            numEjercicio = 0;
                        }
                    }
                }

                //Pierna

                if(valueCat == 13){
                    if(numEjercicio < pierna.length){
                        numEjercicio++;
                        tituloEjercicio.setText(pierna[numEjercicio-1][0]);
                        descripcion.setText(pierna[numEjercicio-1][1]);
                        urlparse = Uri.parse(pierna[numEjercicio-1][2]);
                        countExercices.setText(pierna[numEjercicio-1][3]);
                    }
                    if(numEjercicio == pierna.length){
                        countLevel++;
                        if(countLevel == principiante){
                            register();
                        }
                    }
                }

                if(valueCat == 14){
                    if(numEjercicio < pierna.length){
                        numEjercicio++;
                        tituloEjercicio.setText(pierna[numEjercicio-1][0]);
                        descripcion.setText(pierna[numEjercicio-1][1]);
                        urlparse = Uri.parse(pierna[numEjercicio-1][2]);
                        countExercices.setText(pierna[numEjercicio-1][3]);

                    }
                    if(numEjercicio == pierna.length){
                        countLevel++;
                        if (countLevel == intermedio ){
                            register();
                        }else {
                            numEjercicio = 0;
                        }
                    }
                }

                if(valueCat == 15){
                    if(numEjercicio < pierna.length){
                        numEjercicio++;
                        tituloEjercicio.setText(pierna[numEjercicio-1][0]);
                        descripcion.setText(pierna[numEjercicio-1][1]);
                        urlparse = Uri.parse(pierna[numEjercicio-1][2]);
                        countExercices.setText(pierna[numEjercicio-1][3]);
                    }
                    if(numEjercicio == pierna.length){
                        countLevel++;
                        if (countLevel == avanzado ){
                            register();
                        }else {
                            numEjercicio = 0;
                        }
                    }
                }
                Glide.with(getApplicationContext()).load(urlparse).into(imag);
            }
        });

        //Retroceder ejercicio

        botonRetroceder = (Button) findViewById(R.id.atras);

        if(numEjercicio == 0 && countLevel == 0){
            botonRetroceder.setVisibility(View.INVISIBLE);
        }

        botonRetroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri urlparse = null;


                if(numEjercicio == 1){
                    botonRecorrer.setVisibility(View.INVISIBLE);
                }

                if(numEjercicio > 1){

                    //Abdominales

                    if(valueCat == 1){
                        numEjercicio--;
                        tituloEjercicio.setText(abdominales[numEjercicio-1][0]);
                        descripcion.setText(abdominales[numEjercicio-1][1]);
                        urlparse = Uri.parse(abdominales[numEjercicio-1][2]);
                        countExercices.setText(abdominales[numEjercicio-1][3]);
                    }

                    //Hombros espalda

                    if(valueCat == 4){
                        numEjercicio--;
                        tituloEjercicio.setText(espaldaHombros[numEjercicio-1][0]);
                        descripcion.setText(espaldaHombros[numEjercicio-1][1]);
                        urlparse = Uri.parse(espaldaHombros[numEjercicio-1][2]);
                        countExercices.setText(espaldaHombros[numEjercicio-1][3]);

                    }

                    //Pecho

                    if(valueCat == 7){
                        numEjercicio--;
                        tituloEjercicio.setText(pecho[numEjercicio-1][0]);
                        descripcion.setText(pecho[numEjercicio-1][1]);
                        urlparse = Uri.parse(pecho[numEjercicio-1][2]);
                        countExercices.setText(pecho[numEjercicio-1][3]);
                    }

                    //Brazo

                    if(valueCat == 10){
                        numEjercicio--;
                        tituloEjercicio.setText(brazo[numEjercicio-1][0]);
                        descripcion.setText(brazo[numEjercicio-1][1]);
                        urlparse = Uri.parse(brazo[numEjercicio-1][2]);
                        countExercices.setText(brazo[numEjercicio-1][3]);
                    }

                    //Pierna

                    if(valueCat == 13){
                        numEjercicio--;
                        tituloEjercicio.setText(pierna[numEjercicio-1][0]);
                        descripcion.setText(pierna[numEjercicio-1][1]);
                        urlparse = Uri.parse(pierna[numEjercicio-1][2]);
                        countExercices.setText(pierna[numEjercicio-1][3]);
                    }
                }

                //Abdominales

                if(valueCat == 2){

                    if(countLevel != intermedio && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(abdominales[numEjercicio-1][0]);
                        descripcion.setText(abdominales[numEjercicio-1][1]);
                        urlparse = Uri.parse(abdominales[numEjercicio-1][2]);
                        countExercices.setText(abdominales[numEjercicio-1][3]);
                    }else if(countLevel == intermedio && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(abdominales[numEjercicio-1][0]);
                        descripcion.setText(abdominales[numEjercicio-1][1]);
                        urlparse = Uri.parse(abdominales[numEjercicio-1][2]);
                        countExercices.setText(abdominales[numEjercicio-1][3]);
                    }else if(countLevel == intermedio && numEjercicio == 0){
                        numEjercicio = abdominales.length;
                        countLevel--;
                        tituloEjercicio.setText(abdominales[numEjercicio-1][0]);
                        descripcion.setText(abdominales[numEjercicio-1][1]);
                        urlparse = Uri.parse(abdominales[numEjercicio-1][2]);
                        countExercices.setText(abdominales[numEjercicio-1][3]);
                    }
                }

                if(valueCat == 3){

                    if(countLevel != avanzado && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(abdominales[numEjercicio-1][0]);
                        descripcion.setText(abdominales[numEjercicio-1][1]);
                        urlparse = Uri.parse(abdominales[numEjercicio-1][2]);
                        countExercices.setText(abdominales[numEjercicio-1][3]);
                    }else if(countLevel == avanzado && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(abdominales[numEjercicio-1][0]);
                        descripcion.setText(abdominales[numEjercicio-1][1]);
                        urlparse = Uri.parse(abdominales[numEjercicio-1][2]);
                        countExercices.setText(abdominales[numEjercicio-1][3]);
                    }else if(countLevel == avanzado && numEjercicio == 0){
                        numEjercicio = abdominales.length;
                        countLevel--;
                        tituloEjercicio.setText(abdominales[numEjercicio-1][0]);
                        descripcion.setText(abdominales[numEjercicio-1][1]);
                        urlparse = Uri.parse(abdominales[numEjercicio-1][2]);
                        countExercices.setText(abdominales[numEjercicio-1][3]);
                    }
                }

                //Hombros y espalda

                if(valueCat == 5){

                    if(countLevel != intermedio && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(espaldaHombros[numEjercicio-1][0]);
                        descripcion.setText(espaldaHombros[numEjercicio-1][1]);
                        urlparse = Uri.parse(espaldaHombros[numEjercicio-1][2]);
                        countExercices.setText(espaldaHombros[numEjercicio-1][3]);
                    }else if(countLevel == intermedio && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(espaldaHombros[numEjercicio-1][0]);
                        descripcion.setText(espaldaHombros[numEjercicio-1][1]);
                        urlparse = Uri.parse(espaldaHombros[numEjercicio-1][2]);
                        countExercices.setText(espaldaHombros[numEjercicio-1][3]);
                    }else if(countLevel == intermedio && numEjercicio == 0){
                        numEjercicio = espaldaHombros.length;
                        countLevel--;
                        tituloEjercicio.setText(espaldaHombros[numEjercicio-1][0]);
                        descripcion.setText(espaldaHombros[numEjercicio-1][1]);
                        urlparse = Uri.parse(espaldaHombros[numEjercicio-1][2]);
                        countExercices.setText(espaldaHombros[numEjercicio-1][3]);
                    }
                }

                if(valueCat == 6){

                    if(countLevel != avanzado && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(espaldaHombros[numEjercicio-1][0]);
                        descripcion.setText(espaldaHombros[numEjercicio-1][1]);
                        urlparse = Uri.parse(espaldaHombros[numEjercicio-1][2]);
                        countExercices.setText(espaldaHombros[numEjercicio-1][3]);
                    }else if(countLevel == avanzado && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(espaldaHombros[numEjercicio-1][0]);
                        descripcion.setText(espaldaHombros[numEjercicio-1][1]);
                        urlparse = Uri.parse(espaldaHombros[numEjercicio-1][2]);
                        countExercices.setText(espaldaHombros[numEjercicio-1][3]);
                    }else if(countLevel == avanzado && numEjercicio == 0){
                        numEjercicio = espaldaHombros.length;
                        countLevel--;
                        tituloEjercicio.setText(espaldaHombros[numEjercicio-1][0]);
                        descripcion.setText(espaldaHombros[numEjercicio-1][1]);
                        urlparse = Uri.parse(espaldaHombros[numEjercicio-1][2]);
                        countExercices.setText(espaldaHombros[numEjercicio-1][3]);
                    }
                }

                //Pecho

                if(valueCat == 8){

                    if(countLevel != intermedio && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(pecho[numEjercicio-1][0]);
                        descripcion.setText(pecho[numEjercicio-1][1]);
                        urlparse = Uri.parse(pecho[numEjercicio-1][2]);
                        countExercices.setText(pecho[numEjercicio-1][3]);
                    }else if(countLevel == intermedio && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(pecho[numEjercicio-1][0]);
                        descripcion.setText(pecho[numEjercicio-1][1]);
                        urlparse = Uri.parse(pecho[numEjercicio-1][2]);
                        countExercices.setText(pecho[numEjercicio-1][3]);
                    }else if(countLevel == intermedio && numEjercicio == 0){
                        numEjercicio = pecho.length;
                        countLevel--;
                        tituloEjercicio.setText(pecho[numEjercicio-1][0]);
                        descripcion.setText(pecho[numEjercicio-1][1]);
                        urlparse = Uri.parse(pecho[numEjercicio-1][2]);
                        countExercices.setText(pecho[numEjercicio-1][3]);
                    }
                }

                if(valueCat == 9){

                    if(countLevel != avanzado && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(pecho[numEjercicio-1][0]);
                        descripcion.setText(pecho[numEjercicio-1][1]);
                        urlparse = Uri.parse(pecho[numEjercicio-1][2]);
                        countExercices.setText(pecho[numEjercicio-1][3]);
                    }else if(countLevel == avanzado && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(pecho[numEjercicio-1][0]);
                        descripcion.setText(pecho[numEjercicio-1][1]);
                        urlparse = Uri.parse(pecho[numEjercicio-1][2]);
                        countExercices.setText(pecho[numEjercicio-1][3]);
                    }else if(countLevel == avanzado && numEjercicio == 0){
                        numEjercicio = pecho.length;
                        countLevel--;
                        tituloEjercicio.setText(pecho[numEjercicio-1][0]);
                        descripcion.setText(pecho[numEjercicio-1][1]);
                        urlparse = Uri.parse(pecho[numEjercicio-1][2]);
                        countExercices.setText(pecho[numEjercicio-1][3]);
                    }
                }

                //Brazo

                if(valueCat == 11){

                    if(countLevel != intermedio && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(brazo[numEjercicio-1][0]);
                        descripcion.setText(brazo[numEjercicio-1][1]);
                        urlparse = Uri.parse(brazo[numEjercicio-1][2]);
                        countExercices.setText(brazo[numEjercicio-1][3]);
                    }else if(countLevel == intermedio && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(brazo[numEjercicio-1][0]);
                        descripcion.setText(brazo[numEjercicio-1][1]);
                        urlparse = Uri.parse(brazo[numEjercicio-1][2]);
                        countExercices.setText(brazo[numEjercicio-1][3]);
                    }else if(countLevel == intermedio && numEjercicio == 0){
                        numEjercicio = brazo.length;
                        countLevel--;
                        tituloEjercicio.setText(brazo[numEjercicio-1][0]);
                        descripcion.setText(brazo[numEjercicio-1][1]);
                        urlparse = Uri.parse(brazo[numEjercicio-1][2]);
                        countExercices.setText(brazo[numEjercicio-1][3]);
                    }
                }

                if(valueCat == 12){

                    if(countLevel != avanzado && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(brazo[numEjercicio-1][0]);
                        descripcion.setText(brazo[numEjercicio-1][1]);
                        urlparse = Uri.parse(brazo[numEjercicio-1][2]);
                        countExercices.setText(brazo[numEjercicio-1][3]);
                    }else if(countLevel == avanzado && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(brazo[numEjercicio-1][0]);
                        descripcion.setText(brazo[numEjercicio-1][1]);
                        urlparse = Uri.parse(brazo[numEjercicio-1][2]);
                        countExercices.setText(brazo[numEjercicio-1][3]);
                    }else if(countLevel == avanzado && numEjercicio == 0){
                        numEjercicio = brazo.length;
                        countLevel--;
                        tituloEjercicio.setText(brazo[numEjercicio-1][0]);
                        descripcion.setText(brazo[numEjercicio-1][1]);
                        urlparse = Uri.parse(brazo[numEjercicio-1][2]);
                        countExercices.setText(brazo[numEjercicio-1][3]);
                    }
                }

                //pierna

                if(valueCat == 14){

                    if(countLevel != intermedio && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(pierna[numEjercicio-1][0]);
                        descripcion.setText(pierna[numEjercicio-1][1]);
                        urlparse = Uri.parse(pierna[numEjercicio-1][2]);
                        countExercices.setText(pierna[numEjercicio-1][3]);
                    }else if(countLevel == intermedio && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(pierna[numEjercicio-1][0]);
                        descripcion.setText(pierna[numEjercicio-1][1]);
                        urlparse = Uri.parse(pierna[numEjercicio-1][2]);
                        countExercices.setText(pierna[numEjercicio-1][3]);
                    }else if(countLevel == intermedio && numEjercicio == 0){
                        numEjercicio = pierna.length;
                        countLevel--;
                        tituloEjercicio.setText(pierna[numEjercicio-1][0]);
                        descripcion.setText(pierna[numEjercicio-1][1]);
                        urlparse = Uri.parse(pierna[numEjercicio-1][2]);
                        countExercices.setText(pierna[numEjercicio-1][3]);
                    }
                }

                if(valueCat == 15){

                    if(countLevel != avanzado && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(pierna[numEjercicio-1][0]);
                        descripcion.setText(pierna[numEjercicio-1][1]);
                        urlparse = Uri.parse(pierna[numEjercicio-1][2]);
                        countExercices.setText(pierna[numEjercicio-1][3]);
                    }else if(countLevel == avanzado && numEjercicio > 1){
                        numEjercicio--;
                        tituloEjercicio.setText(pierna[numEjercicio-1][0]);
                        descripcion.setText(pierna[numEjercicio-1][1]);
                        urlparse = Uri.parse(pierna[numEjercicio-1][2]);
                        countExercices.setText(pierna[numEjercicio-1][3]);
                    }else if(countLevel == avanzado && numEjercicio == 0){
                        numEjercicio = pierna.length;
                        countLevel--;
                        tituloEjercicio.setText(pierna[numEjercicio-1][0]);
                        descripcion.setText(pierna[numEjercicio-1][1]);
                        urlparse = Uri.parse(pierna[numEjercicio-1][2]);
                        countExercices.setText(pierna[numEjercicio-1][3]);
                    }
                }


                if(numEjercicio == 1){
                    botonRetroceder.setVisibility(View.INVISIBLE);
                }

                botonRecorrer.setText("Siguiente");

                Glide.with(getApplicationContext()).load(urlparse).into(imag);
            }

        });

    }

    private void exitToMain() {
        new AlertDialog.Builder(this)
                .setTitle("Salir al menú principal")
                .setMessage("Desea salir del ejercicio?")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }

    //Metodo para guardar el ejercicio en el historial

    private void register(){
        dbinsert inser = new dbinsert(activityExercicios.this);
        long id = inser.insertRegiste(titulo.getText().toString());

        if(id > 0){
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();

        }

        numEjercicio = 0;
        countLevel = 0;
        finish();
    }

}