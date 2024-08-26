package br.edu.ifsp.scl.ads.pdm.havagas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.ads.pdm.havagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        // Configuração do Spinner (Formacao)
        amb.formacaoSP.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                configurarCamposAdicionais(position)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) { }
        }

    }

    private fun configurarCamposAdicionais(position: Int) {
        amb.anoConclusaoEt.visibility = View.GONE
        amb.instituicaoEt.visibility = View.GONE
        amb.tituloMonografiaEt.visibility = View.GONE
        amb.orientadorEt.visibility = View.GONE

        when (position) {
            1, 2 -> {
                // Fundamental e Médio
                amb.anoConclusaoEt.visibility = View.VISIBLE
                amb.anoConclusaoEt.hint = "Ano de formatura"
            }
            3, 4 -> {
                // Graduação e Especialização
                amb.anoConclusaoEt.visibility = View.VISIBLE
                amb.anoConclusaoEt.hint = "Ano de conclusão"
                amb.instituicaoEt.visibility = View.VISIBLE
            }
            5, 6 -> {
                // Mestrado e Doutorado
                amb.anoConclusaoEt.visibility = View.VISIBLE
                amb.anoConclusaoEt.hint = "Ano de conclusão"
                amb.instituicaoEt.visibility = View.VISIBLE
                amb.tituloMonografiaEt.visibility = View.VISIBLE
                amb.orientadorEt.visibility = View.VISIBLE
            }
        }
    }
}
