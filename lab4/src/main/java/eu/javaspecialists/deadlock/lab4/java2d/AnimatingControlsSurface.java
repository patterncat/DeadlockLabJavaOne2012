/*
 * @(#)AnimatingControlsSurface.java	1.12 06/08/29
 * 
 * Copyright (c) 2006 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * -Redistribution of source code must retain the above copyright notice, this
 *  list of conditions and the following disclaimer.
 * 
 * -Redistribution in binary form must reproduce the above copyright notice, 
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 * 
 * Neither the name of Sun Microsystems, Inc. or the names of contributors may 
 * be used to endorse or promote products derived from this software without 
 * specific prior written permission.
 * 
 * This software is provided "AS IS," without a warranty of any kind. ALL 
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING
 * ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 * OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. SUN MIDROSYSTEMS, INC. ("SUN")
 * AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE
 * AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE FOR ANY LOST 
 * REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL, 
 * INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY 
 * OF LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE, 
 * EVEN IF SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 * 
 * You acknowledge that this software is not designed, licensed or intended
 * for use in the design, construction, operation or maintenance of any
 * nuclear facility.
 */

/*
 * @(#)AnimatingControlsSurface.java	1.12 06/08/29
 */

package eu.javaspecialists.deadlock.lab4.java2d;

import java.awt.*;

import static eu.javaspecialists.deadlock.lab4.java2d.CustomControlsContext.State.*;

/**
 * Demos that animate and have custom controls extend this class.
 */
public abstract class AnimatingControlsSurface extends AnimatingSurface implements CustomControlsContext {

  public void setControls(Component[] controls) {
    this.controls = controls;
  }

  public void setConstraints(String[] constraints) {
    this.constraints = constraints;
  }

  public String[] getConstraints() {
    return constraints;
  }

  public Component[] getControls() {
    return controls;
  }

  public void handleThread(CustomControlsContext.State state) {
    for (Component control : controls) {
      if (control instanceof CustomControls) {
        if (state == START) {
          ((CustomControls) control).start();
        } else {
          ((CustomControls) control).stop();
        }
      }
    }
  }


  private Component[] controls;
  private String[] constraints = {java.awt.BorderLayout.NORTH};
}
